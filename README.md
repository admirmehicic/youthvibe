# youthvibe
Youthvibe predstavlja projekat grupe studenata treće godine studija Softverskog inžinjerstva, Politehničkog fakulteta Univerziteta u Zenica. Kroz ovaj projekat, kreirana je web aplikacija putem koje mladi mogu razmjenivati korisne informacije o prilikama za mlade u zajendnici.


Projekat je implementiran kao web aplikacija kojoj se pristupa putem web browsera. U sklopu ovog projekta korištene su sljedeće tehnologije: HTML, CSS, Java programski jezik, Spring framework, Thymleaf te MySQL za bazu podataka. Aplikacija je pokrenuta na lokalnom hostu i omogućava korisniku sljedeće funkcionalnosti:
1. pregled objavljenih prilika - za prikaz ovog view-a je korišten kontroler u kojem se dohvataju podaci iz tabele 'prilike'. Nakon toga se dohvaćeni podaci proslijeđuju prema idućem view-u. Za adekvatnog formatiranje dohvaćenih podataka, korištena je Thymeleaf tehnologija.
2. postavljanje prilika - putem forme, korisnik unosi podatke koji se odnose na neke prilike za mlade iz zajednice (naslov, opis, datum, lokacija) te se vrši INSERT podataka u tabelu 'news'. Nakon toga se vrši unos podataka u bazu.
3. pregled i postavljanje vijest - na istom principu se vrši pregled objavljenih vijesti.

Funkcionalnosti registracije:
1. postoji mogućnost registracije korisnika - unos podataka u formu te njihovo postavljanje u odgovarajuću tabelu 'korisnici' u bazi podataka
2. admin prijava - sa pristupnim podacima admin/admin može se vršiti pregled i upravljanje svim korisnicima iz baze
3. prijava korisnika - nakon registracije, korisnik se prijavljuje sa svojim korisničkim podacima
4. prijavljenim korisnicima se omogućava postavljanje vijesti.
5. prijavljenim korisnicima se pruža mogućnost odjave te povratak na povratak na početnu stranicu.
