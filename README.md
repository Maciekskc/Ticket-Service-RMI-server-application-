Opis:
	Program tworzy zdalny obiekt centrali
	i umieszcza go w rejestrze RMI, Obiekty klas zdalnych
	w nim umieszczone obs�uguj� dodawanie kolejnych Klient�w,
	Okienek do obs�ugi i monitor�w. Klasa implementuj�ca interface zdalny centrali(umieszczona w rejestrze RMI)
	zawiera list� interfac-�w zdalnych monitor�w i w przypadku wykonania
	akcji dodawania/usuwania z bilet�w wysy�a sygna�y od�wie�ania ekran�w monitor�w.
	Obiekt klienta posiada interface zdalny centrali i przy pobieraniu biletu zostaje on utworzony w centrali
	sk�d obiekty klasy servant mog� je pobra� i obs��y� r�wnie� za pomoc� tego interfacu.
	
Uruchamianie
	1) App
	2) nast�pnie dowolna ilo�� klas "Servant", "Client", "Monitor"
