# MonsterInterviewExercise
Task for interview - Automation test with Selenide

1) Go to https://www.monsterworksdemo.com/home/
2) Create account
3) In page footer click on Philips Jobs under Popular Companies
4) In the job search results page, open 2nd and last job listing and Save it.
5) Navigate to My Job Search > Saved Jobs and validate the saved jobs.

Please have this flow automated using following tools:
 - Chrome browser
 - Java language
 - TestNG
 - Selenide
 
 Comments:
  - The application contains some bugs and currently the process ends on account creation, because of error message. If we want to continue through this step, we can use the maven profile 'doNotEndTestAfterAccountCreationError'.
  - Could not test comparing list of saved jobs and actual saved jobs on profile, because saving job did not work for me. It is implemented, but not tested.
  - DatePicker in registration form - Difficult to use for automation and for user as well
  - Only xpaths usage - I use only xpaths, but I am also aware of other possible methods, and I am prepared to use them if requested :)
  - Exception handling - In real life more custom exception would be defined from my side
  - Only required field used in registration form
  - Dynamic IDs in registration form are surprise :), therefore I use special locators with usage of relationship label + input 
  - In real project there would be paid more attention to split tests / steps into more atomics units - current suite maybe would be composed as suite from more tests.
  - After clicking on save job it gets stuck on blank page
  - In real project I would use properties files for some values (Urls, ...)
