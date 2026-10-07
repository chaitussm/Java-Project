#!/usr/bin/env bash
set -euo pipefail
ROOT="$(cd "$(dirname "$0")/.." && pwd)"
cd "$ROOT"

find_java8() {
  if [ -n "${JAVA_8_HOME:-}" ] && [ -x "${JAVA_8_HOME}/bin/java" ]; then
    echo "${JAVA_8_HOME}/bin/java"
    return 0
  fi
  for candidate in \
    /usr/lib/jvm/java-8-openjdk-amd64/bin/java \
    /usr/lib/jvm/temurin-8-jdk-amd64/bin/java \
    /usr/lib/jvm/java-1.8.0-openjdk-amd64/bin/java; do
    if [ -x "$candidate" ]; then
      echo "$candidate"
      return 0
    fi
  done
  if command -v java >/dev/null 2>&1; then
    version="$(java -version 2>&1 | head -1)"
    if [[ "$version" == *"1.8"* ]] || [[ "$version" == *"8."* ]]; then
      echo java
      return 0
    fi
  fi
  return 1
}

JAVA8="$(find_java8)" || {
  echo "Java 8 is required to run this lab (-Djava.ext.dirs is not supported on JDK 9+)."
  echo "Install a JDK 8 or set JAVA_8_HOME, then re-run."
  exit 1
}

"$ROOT/scripts/build-classpath-lab.sh"

exec "$JAVA8" \
  -Djava.ext.dirs="$ROOT/classpath-lab/ext" \
  -cp "$ROOT/classpath-lab/app/customer.jar:$ROOT/classpath-lab/app/classes" \
  com.jvmArchitecture.HowClassLoaderWorks.Test
