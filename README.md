# Accounting Ledger Application
With this application, the user will be able to track all their financial transactions, be it for a business or for personal use.

- Users are able to make a deposit or payment to their accounts
- Users are able to access their ledger to view all transactions, including all their deposits and/or payments
- Users are able to access their accounts reports through either pre-defined reports or custom search

## Home Screen

#### The Home Screen is where users are prompted to:
- Make a deposit (which is reflected as a credit to their accounts)
- Make a payment (which is reflected as a debit to their accounts)
- View their accounts ledger
- Simply exit the application

><details>
><summary> Welcome Screen </summary>
>
>![HomeScreen.PNG](HomeScreen.PNG)
></details>

><details>
><summary> Deposits </summary>
>
>#### If the user chooses 'Make a Deposit', they are then prompted to:
>- Enter in the reason/description as to why they are making this deposit
>- Enter in the name of the vendor making the deposit
>- Enter in the amount they would like to deposit
>
>#### Afterwards, the user is given a confirmation message ensuring that their deposit has been properly recorded without any issues.
>
>><details>
>><summary> Making a Deposit </summary>
>>
>>![Depositing.PNG](Depositing.PNG)
>></details>
></details>

><details>
><summary> Payments </summary>
>
>#### If the user chooses 'Make a Payment', they are then prompted to:
>- Enter in the reason/description as to why they are making this payment
>- Enter in the name of the vendor making the payment
>- Enter in the amount they would like to pay
>
>#### Afterwards, the user is given a confirmation message ensuring that their payment has been properly recorded without any issues.
>
>><details>
>><summary> Making a Payment </summary>
>>
>>![Paymenting.PNG](Paymenting.PNG)
>></details>
></details>

## Ledger Screen
#### The Ledger Screen is where users are prompted to:
- View all the transactions on their account
- View all deposits made on their account
- View all their payments made on their account
- View Reports 
- Return back to the Home Screen

><details>
><summary> Ledger Screen </summary>
>
>![LedgerScreen.PNG](LedgerScreen.PNG)
></details>

><details>
><summary>Viewing all Transactions</summary>
>
>#### If the user chooses 'View all Transactions', they are shown a list of all the transactions performed on their account.
>- This includes both deposits and payments.
>- Payments are signified by a "-" sign
>
>><details>
>><summary> All Transactions </summary>
>>
>>![DisplayAll.PNG](DisplayAll.PNG)
>></details>
></details>

><details>
><summary> Viewing Deposits </summary>
>
>#### If the user chooses 'View Deposits', they are shown a list of all the deposits performed on their account.
>
>><details>
>><summary> All Deposits </summary>
>>
>>![Deposits.PNG](Deposits.PNG)
>></details>
>></details>

><details>
><summary> Viewing Payments </summary>
>
>#### If the user chooses 'View Payments', they are shown a list of all the payments performed on their account.
>- The amounts are displayed with a "-" sign because payments are registered as credits to a user's account
>><details>
>><summary> All Payments </summary>
>>
>>![Payments.PNG](Payments.PNG)
>></details>
></details>

## Reports Screen
#### The Reports Screen allows the user to either execute pre-defined reports or conduct a customized search.
#### These pre-defined reports enable the user to explore their transactions by:
- Month to Date
- Previous Month
- Year to Date
- Previous Year
#### The user is also able to:
- Search by vendor
- Conduct a custom search
#### All these reports display both the user's deposits and payments.
><details>
><summary> Reports Screen </summary>
>
>(image here)
></details>

><details> 
><summary> Month to Date </summary>
>
>#### If the user chooses 'Month to Date', the application will load and display all the user's transactions from the current month to the current date.
>><details>
>><summary> View Month to Date </summary>
>>
>>(image here)
>></details>
></details>

><details>
><summary> Previous Month </summary>
>
>#### If the user chooses 'Previous Month', the application will load and display all the user's transactions from the previous month.
>><details>
>><summary> View Previous Month </summary>
>>
>>(image here)
>></details>
></details>

><details>
><summary> Year to Date </summary>
>
>#### If the user chooses 'Year to Date', the application will load and display all the user's transactions from the current year to the current date.
>><details>
>><summary> View Year to Date </summary>
>>
>>(image here)
>></details>
></details>

><details>
><summary> Previous Year </summary>
>
>#### If the user chooses 'Previous Year', the application will load and display all the user's transactions from the previous year.
>><details>
>><summary> View Previous Year </summary>
>>
>>(image here)
>></details>
></details>

><details>
><summary> Search by Vendor </summary>
>
>#### If the user chooses 'Search by Vendor', the user will be prompted to enter the name of the vendor they want to look up in their transactions. 
>#### Afterwards, the application will display all the transactions involving that vendor.
>><details>
>><summary> Searching by Vendor </summary>
>>
>>(image here)
>></details>
></details>

## Interesting Piece of Code
```System.out.println("* Please enter in the vendor name:");
vendorInput = scanner.nextLine().trim();
String vendorOutput = vendorInput.substring(0, 1).toUpperCase() + vendorInput.substring(1);
```
I chose these lines of code because I was trying to figure out how to error handle if the user were to potentially enter in vendor name but in all lowercase.
This would be a problem because I had the first letter of all the data in the transactions.txt capitalized and if the user were to enter an input in all lowercase, the program would not run.

However, after some time of researching, I found this one simple line of code that would prevent this from happening by forcing the first letter of the user input to always be capitalized.
I then took this line of code and ended up applying it in different areas of my code.