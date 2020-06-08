# MonsterInterviewExcercise
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
  - DatePicker in registration form - Difficult usage as for automation as for user
  - Only xpaths usage - I use only xpaths, but I am also aware of other methods and I am prepared to use them if requested :)
  - Exception handling - In real life more custom exception would be define from my side
  - Only required field used in registration form
  - Dynamic IDs in registration form are surprise :), therefore I use special locators with usage of relationship label + input 
  - In real life there would be payed more attention to split tests / steps into more atomics units
