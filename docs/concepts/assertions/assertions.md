# Introduction

Very common way of debugging is usage of sop (System.out.println) statements. But the problem with sop's is after fixing the bug/defect compulsory we have to delete sop statements otherwise these sop's will be executed at runtime for every client request , which creates performace problem and disturbs server logs, 
      To overcome this problem sun people introduced assertions concept in 1.4 version

The main advantage of assertions when compared with sop's is after fixing the bug/defect we are not required to remove assert statements because they won't be executed by default at runtime based on our requirement we can enable and disable assertions and by default assertions are disabled.

The main objective of assertions is to perform debugging by validating assumptions made in the code during development.

Usually we can perform debugging in developement and test environments but not in production environment , hence assertions concept applicable mainly in development and test environments but not for production environment.




# assert as keyword and identifier 
