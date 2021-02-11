#Answering the quesstions

## Explain how you ensure user is the right one starting the app

To ensure user is the right at the starting of the phone, we have decided to force him to login using the fingerprint used to unlock the phone. If there is no fingerprint registred on the phone or there is any probleme, the user can use the pin code.


## How do you securely save user's data on your phone ?

To ensure the user's data's safety we are encrypting the databaste where his data are saved with sqlCipher.

## How did you hide the API url ?

To hide the APi url, we stored it in a compiled c++ file which is after obfuscated by proguard.

## Screenshots

![fingerprint page image](/images/fingerprint.png)

![code page image](/images/code.png)

![main page image](/images/main.png)
