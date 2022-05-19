package model;


public class House  {



    private int buildingPrice;

    private int rentIncrease;
    
    private int price1;
    private int price2;
    private int price3;
    private int price4;
    private int priceHotel;



    private int counter = 0;

    public House(int bh, int p1, int p2, int p3, int p4, int ph  ){
       
        buildingPrice = bh;
        price1 = p1;
        price2 = p2;
        price3 = p3;
        price4 = p4;
        priceHotel = ph;

    }


    public int getPrice(int i){
        switch(i){
            case 1:
            return price1;
            case 2:
            return price2;
            case 3:
            return price3;
            case 4:
            return price4;
            case 5:
            return priceHotel;
            case 6:
            return buildingPrice;
            default:
                return 0;
        }
    }




    
    public void buildHouse(int num){

        counter += num;

        if (counter > 5) counter = 5;

    }


    public int payHouse(int num){

        buildHouse(num);

        return buildingPrice * num;

    }


    // public void buildHotel(){

    //     counter = 5;

    // }


    // public int payHotel(){
    //     buildHotel();
    //     return buildingPrice;
    // }




    public int getCounter(){
        return counter;
    }




    public boolean checkNumHouses(int num){
        return (counter + num) <= 4;
    }
}