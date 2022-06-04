package com.example.dressforweth;


import java.util.ArrayList;

public class Clothes {
    private int image;
    private String name;
    private String description;

    public Clothes(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public Clothes() {

    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    static Clothes botinki = new Clothes(R.drawable.bot, "ботинки","в них ногам точно будет тепло");
    static Clothes futbolka = new Clothes(R.drawable.futbolka, "футблока","это футболка");
    static Clothes girlFutbolka = new Clothes(R.drawable.girlfutbolka, "футблока","это футболка");
    static Clothes girlHat = new Clothes(R.drawable.girlhat,"головной убор","защитит от солнца");
    static Clothes girlMaika = new Clothes(R.drawable.girlmaika,"майка","это майка");
    static Clothes hat = new Clothes(R.drawable.hat,"головной убор","защитит от солнца");
    static Clothes ked = new Clothes(R.drawable.ked,"кеды","это кеды");
    static Clothes kofta = new Clothes(R.drawable.kofta,"кофта","это кофта");
    static Clothes kros = new Clothes(R.drawable.kros,"кросовки","это кросовки");
    static Clothes kurtka = new Clothes(R.drawable.kurtka,"куртка","это куртка");
    static Clothes maika = new Clothes(R.drawable.maika,"майка","это майка");
    static Clothes pants = new Clothes(R.drawable.pants,"штаны","это штаны");
    static Clothes platie = new Clothes(R.drawable.platie,"платье","это платье");
    static Clothes puhovik = new Clothes(R.drawable.puhovik,"пуховик","это пуховик");
    static Clothes rubashka = new Clothes(R.drawable.rubashka,"рубашка","это рубашка");
    static Clothes sandals = new Clothes(R.drawable.sandals,"сандали","носить только с носками");
    static Clothes shapka = new Clothes(R.drawable.shapka,"шапка","чтоб голова не мёрзла");
    static Clothes shorts = new Clothes(R.drawable.shorts,"шорты","это шорты");
    static Clothes vetrovka = new Clothes(R.drawable.vetrovka,"ветровка","защищает от ветра");
    static Clothes yubka = new Clothes(R.drawable.yubka,"юбка","это юбка");
    static Clothes zontik = new Clothes(R.drawable.zontik,"зонтик","это зонтик");


    public void showClothesM(double t, String r, double w, ArrayList<Clothes> clothesList){
        clothesList.clear();
        //t>20
        if (t > 20 & r.equals("Солнечно") & w < 7) {
            clothesList.add(hat);
            clothesList.add(maika);
            clothesList.add(shorts);
            clothesList.add(sandals);
        }

        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w < 7){
            clothesList.add(futbolka);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        if (t > 20 & !r.equals("Дождь") & w >= 7){
            clothesList.add(futbolka);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        if (t > 20 & r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(rubashka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        if (t > 20 & r.equals("Дождь") & w >= 7){
            clothesList.add(vetrovka);
            clothesList.add(rubashka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //t >= 10 & t <= 20
        if(t >= 10 & t <= 20 & !r.equals("Дождь") & w < 7){
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        if(t >= 10 & t <= 20 & !r.equals("Дождь") & w >= 7){
            clothesList.add(rubashka);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        if(t >= 10 & t <= 20 & r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        if(t >= 10 & t <= 20 & r.equals("Дождь") & w >= 7){
            clothesList.add(kofta);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //t <10 & t > -15
        if (t <10 & t > -15 & !r.equals("Дождь"))
        {
            clothesList.add(shapka);
            clothesList.add(futbolka);
            clothesList.add(kurtka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        if (t <10 & t > -15 & r.equals("Дождь") & w < 7)
        {
            clothesList.add(zontik);
            clothesList.add(shapka);
            clothesList.add(futbolka);
            clothesList.add(kurtka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //<= -15
        if (t <= -15 )
        {
            clothesList.add(shapka);
            clothesList.add(rubashka);
            clothesList.add(puhovik);
            clothesList.add(pants);
            clothesList.add(botinki);
        }

    }

    public static void showClothesF(double t, String r, double w,ArrayList<Clothes> clothesList){
        clothesList.clear();

        //t>20
        if (t > 20 & r.equals("Солнечно") & w < 7) {
            clothesList.add(girlHat);
            clothesList.add(platie);
            clothesList.add(sandals);
        }

        if (t > 20 & !r.equals("Солнечно") & !r.equals("Дождь") & w < 7){
            clothesList.add(girlMaika);
            clothesList.add(yubka);
            clothesList.add(kros);
        }

        if (t > 20 & !r.equals("Дождь") & w >= 7){
            clothesList.add(girlFutbolka);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        if (t > 20 & r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(rubashka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        if (t > 20 & r.equals("Дождь") & w >= 7){
            clothesList.add(vetrovka);
            clothesList.add(rubashka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //t >= 10 & t <= 20
        if(t >= 10 & t <= 20 & !r.equals("Дождь") & w < 7){
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        if(t >= 10 & t <= 20 & !r.equals("Дождь") & w >= 7){
            clothesList.add(rubashka);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(kros);
        }

        if(t >= 10 & t <= 20 & r.equals("Дождь") & w < 7){
            clothesList.add(zontik);
            clothesList.add(kofta);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        if(t >= 10 & t <= 20 & r.equals("Дождь") & w >= 7){
            clothesList.add(kofta);
            clothesList.add(vetrovka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //t <10 & t > -15
        if (t <10 & t > -15 & !r.equals("Дождь"))
        {
            clothesList.add(shapka);
            clothesList.add(futbolka);
            clothesList.add(kurtka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        if (t <10 & t > -15 & r.equals("Дождь") & w < 7)
        {
            clothesList.add(zontik);
            clothesList.add(shapka);
            clothesList.add(futbolka);
            clothesList.add(kurtka);
            clothesList.add(pants);
            clothesList.add(ked);
        }

        //<= -15
        if (t <= -15 )
        {
            clothesList.add(shapka);
            clothesList.add(rubashka);
            clothesList.add(puhovik);
            clothesList.add(pants);
            clothesList.add(botinki);
        }


    }

}