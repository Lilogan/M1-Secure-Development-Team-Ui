# Answering questions

## Explain how you ensure user is the right one starting the app

To do so, we have decided to force him to login using the fingerprint used to unlock the phone. If there is no fingerprints registred in the phone or there is any problem, the user can use his pin code.

## How do you securely save user's data on your phone ?

To ensure the user's data's safety, we are encrypting the database where his data are saved with sqlCipher.

## How did you hide the API url ?

To hide the API url, we stored it in a compiled c++ file which is after obfuscated by proguard.

## Screenshots

![](/images/fingerprint.png)

![](/images/code.png)

![](/images/main.png)
