Per utilizzare l'Autofill Framework di Android bisogna aver installato un'app di autofill come android-AutofillFramework-master che permette di analizzare i campi di un form e vedere se è settato il tag: android:autofillHints="...", se è settato questo tag allora il servizio di autofill controlla la firma e suggerisce le credenziali precedentemente inserite

Funzionamento del servizio di Google di Autofill.
Una volta inserite le credenziali in un form di login controllo inserisco attraverso la funzione putPackageSignatures della classe SharedPrefsPackageVerificationRepository 
