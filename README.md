# TimesheetHelper
## Purpose
This application is used to fill in the time sheet for a specific timesheet system.
## Environment
This application can be run in macOS 10.13.1 (64 bit) and Windows 10 (64 bit).
## Web Driver Version
- chromedriver(for mac): 2.33
- chromedriver.exe (for windows 64 bit): 2.33
* geckodriver (for mac): 0.19.1
* geckodriver.exe (fro windows 64 bit): 0.19.1
##  Usage Steps
1. Clone the repo to your local.
2. Find the _**application.properties**_ file in the resource folder /src/main/resources.
3. Change the below values as needed
   - username
   - password
   - browser (Currently only support **Chrome** (Version 62.0) and **Firefox** (Version 56.0))
   - hour (The hour to be filled in the time sheet system)
   - comment (The comment for the time entered)
   - fileName (The file name of the timesheet to be upload)
4. Copy the time sheet file under the root directory of the foler, like _**TimesheetHelper/timesheet.pdf**_
5. Make sure you have proper version of browser installed.
6. Run the TimesheetHelper through AppRun class main method.

## 
If you have any question, feel free to contact me:smiley:
