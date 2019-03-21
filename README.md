Opis:
	Program tworzy zdalny obiekt centrali
	i umieszcza go w rejestrze RMI, Obiekty klas zdalnych
	w nim umieszczone obs³uguj¹ dodawanie kolejnych Klientów,
	Okienek do obs³ugi i monitorów. Klasa implementuj¹ca interface zdalny centrali(umieszczona w rejestrze RMI)
	zawiera listê interfac-ów zdalnych monitorów i w przypadku wykonania
	akcji dodawania/usuwania z biletów wysy³a sygna³y odœwie¿ania ekranów monitorów.
	Obiekt klienta posiada interface zdalny centrali i przy pobieraniu biletu zostaje on utworzony w centrali
	sk¹d obiekty klasy servant mog¹ je pobraæ i obs³ó¿yæ równie¿ za pomoc¹ tego interfacu.
	
Uruchamianie
	1) App
	2) nastêpnie dowolna iloœæ klas "Servant", "Client", "Monitor"
