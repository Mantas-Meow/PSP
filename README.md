# Lab 1
Added Unit tests to alpha branch.

# Lab 2
Got Unit test from https://github.com/monikazabukaite/PSP.

Had to implement Validation classes/methods using these tests.

This can be found in the Lab2 branch.

Feedback:

* The Unit tests were pretty easy to read but they did not cover all edge cases, for example, if the test had to check string length it only checked if it is longer than X it didn't check cases where String is shorter than X and so on.
* The Unit tests tested individual methods instead of one general validation method.
* To improve these tests I would try to cover more edge cases, use one general validate method. There was no clear indicator of what are special symbols and what country codes should be included in PhoneValidator.
* There should be added tests to check if strings are empty and, as I mentioned previously, tests should check correct and wrong behavior of given methods.

# Lab 3
Got validator from https://github.com/Kristupaz/PSP

Had to use the provided validator.

This can be found in the 1.3-Lab branch.

Feedback:
* I converted the library that I got to .jar file but the resources folder moved and in the provided validator the static path does not find the files and throws exeptions. Because of that 2 out of 3 validators are not working.
* The validators themselfs are quite well written and it's intuative to use them.
