#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
LAB="$ROOT/classpath-lab"
PKG="com/jvmArchitecture/HowClassLoaderWorks"
SRC="$ROOT/src/main/java/$PKG"
BUILD="$LAB/build"

pick_javac() {
  if [ -n "${JAVA_CLASSLOADER_LAB_JAVAC:-}" ]; then
    echo "$JAVA_CLASSLOADER_LAB_JAVAC"
    return 0
  fi
  for candidate in \
    /usr/lib/jvm/java-21-openjdk-amd64/bin/javac \
    /usr/lib/jvm/java-17-openjdk-amd64/bin/javac \
    /usr/bin/javac; do
    if [ -x "$candidate" ]; then
      echo "$candidate"
      return 0
    fi
  done
  command -v javac
}

JAVAC="$(pick_javac)"
JAVA_RELEASE="${JAVA_CLASSLOADER_LAB_RELEASE:-8}"

compile_release() {
  if "$JAVAC" --help 2>&1 | grep -q -- '--release'; then
    "$JAVAC" -Xlint:-options --release "$JAVA_RELEASE" "$@"
  else
    "$JAVAC" -Xlint:-options -source "$JAVA_RELEASE" -target "$JAVA_RELEASE" "$@"
  fi
}

rm -rf "$LAB/ext" "$LAB/app" "$BUILD"
mkdir -p "$BUILD/ext/$PKG" "$BUILD/app/$PKG" "$LAB/ext" "$LAB/app/classes/$PKG"

compile_release -d "$BUILD/ext" "$SRC/Customer.java"
jar cf "$LAB/ext/customer.jar" -C "$BUILD/ext" .

cp "$LAB/ext/customer.jar" "$LAB/app/customer.jar"
compile_release -cp "$LAB/ext/customer.jar" -d "$BUILD/app" "$SRC/Test.java"
cp "$BUILD/app/$PKG/Test.class" "$LAB/app/classes/$PKG/"

echo "Built classpath lab under $LAB (bytecode release $JAVA_RELEASE)"
