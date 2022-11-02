# Kodlama.io.Devs
***

**Req 1** : Sistemde programlama dilleri tutulmalıdır.

- Programlama dillerini(C#,Java,Python) ekleyebilecek, silebilecek, güncelleyebilecek, listeleyebilecek, id ile getirebilecek kodları yazınız. Bunu tamamen in memory yapınız.

- İsimler tekrar edemez.

- Programlama dili boş geçilemez. (Validation kullanmadan, kod yazarak algoritmik çözünüz)

***

## Kullanım
- API adresi: http://localhost:8080/
 
***

## Endpointler
- /api/languages/getall : GET - Tüm programlama dillerini getirir.
- /api/languages/{id} :  GET - Programlama dili id'sine göre getirir.
- /api/languages/add : POST - Programlama dili ekler.
- /api/languages/getall{id} : PUT - Programlama dili günceller.
- /api/languages/delete/{id} : DELETE - Programlama dili siler.

