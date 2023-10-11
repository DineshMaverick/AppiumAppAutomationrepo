## Getting started with Appium Automation Framework to create test automation build for yahoo mobile app in android device
### Setup:
* Install Java jdk-11.0.19_windows-x64_bin.zip (https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html)
* Install Maven [Maven](https://maven.apache.org/)
* Set JAVA_HOME,NODE_HOME.
* Set the following path variables accordingly[jdk-11/bin,  node-js, npm/bin] 
* Setup the project by importing it in the Eclipse IDE.

### Setting up appium on windows
* Go to https://developer.android.com/studio and Download android-studio-2022.3.1.20-windows.exe
* To Install Android Studio, Click Next button
* Check Android virtual Device check if not checked and click Next
* Again Click Next button and Click Install
* Choose do not “import import my settings” and Click OK
* Click Next and select Standard
* Again Click Next & Next
* On Verify Setting page, Click Finish
* Wait for Libraries to download
* Click Tools and Select SDK Manager
* Select Androidn SDK from the left pane and click on SDKTools Tab
* Check the Hide Obsolete Packages checkbox and select Android SDK Platform tools and click on Apply.


### Setting ANDROID_HOME 
* Set  ANDROID_HOME environment variable to AndroidSDK home location where tools and build-tools folders are located 
* Now set path variable to sdk/tools/bin, sdk/platformtools
* Now create sample project in Android SDK
* And install all the missing Libraries (They are displaying as error with Install button)

####################### Procedure to launch an Device Emulator from the Device Manger   ##################

* Click Device Icon on Top right in android studio
* Click on “Create Virtual Device”
* Select Hardware window will be displayed
* Select Any device Let say Pixel XL and Click Next
* Click Download API level 27 and Click Next & Finish
* Your virtual device screen will be displayed
* Now click on Launch your device

######################  Procedure to connect a real device via USB  ######################

* Connect a real device via USB cable to the laptop.
* Click on tools on the top and select Device manager
* Click on Physical Devices and select Running Devices in the right pane.
* Enable screen Mirroring option by checking the respective checkbox in the settings.
* Connected Device will be displayed.


### Setting Up appium
* First download Latest LTS Version: 18.18.0 from https://nodejs.org/en/download 
* Open cmd and run the below command after successful installation of nodejs.
* "npm install -g" to install appium
* Download "Appium-Server-GUI-windows-1.22.3-4.zip" for starting the server from https://github.com/appium/appium-desktop/releases
* Let’s click the “Advanced” tab and change the Server Address as “127.0.0.1” and click Allow Session Override for override session when there will be problems and click “Start Server”.
* Click Allow access if window with Allow Access appear
* Appium server running message should be displayed

### Exceute Test
* Right click the project directory and click on Runas--> Maven buid --> Goals[type "clean install"] --> click run.
* Automation build will run generate the Extent Report.
* Refer the generated report in the following path : test-output/testReport.html


