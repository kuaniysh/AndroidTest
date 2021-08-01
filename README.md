# AndroidTest
Test project with Kotlin, Espresso, Kakao and CircleCI

What I have done:
- UI tests implemented from scratch( 2 tests for Login, 1 test for the Search)
- Config.yml file created to Run tests on CircleCI + Firebase Test Lab

UX/UI Issues/Recommendations | Demo App:
- There is no network outage handling, e.g. Login Screen needs some messages if user tries to login without internet connection.
- Snackbar in Login Screen is not visible to user, because it appears behind the keyboard.
- There is no any validators for blank login or password, Login Button should be disabled if Edittexts are empty.
- Search bar needs loader when fetching drivers or searching.
- Search bar needs error message if anybody was not found.

TODO: Delete project after review
