public class Car{
    public String model;
    public int year;

    public Car(String model, int year){
        this.model = model;
        this.year = year;
    }

    public void displayInfo(){
        System.out.println(String.format("Model: %s\nYear: %s", model, year));
    }

    public String getModel(){
        return model;
    }

    public int getYear(){
        return year;
    }

    public void compareCars(Car carTarget){
        System.out.println("\nComparando instâncias:");
        System.out.println(String.format("Carro 1: %s\nCarro 2: %s", this, carTarget));
        System.out.println(this == carTarget ? "--> Mesma instância" : "--> Instâncias diferentes");
        System.out.println("\nComparando modelos e anos:");
        System.out.println(String.format("Carro 1: %s - %s\nCarro 2: %s - %s",
                                        this.model,
                                        this.year,
                                        carTarget.model,
                                        carTarget.year));
        System.out.println(this.model.equals(carTarget.model) ? "--> Modelos iguais" : "--> Modelos diferentes");
        System.out.println(this.year == carTarget.year ? "--> Mesmo ano" : "--> Anos diferentes");

    }

    public static void main(String[] args){
        Car car1 = new Car("Civic", 2022);
        Car car2 = new Car("Civic", 2020);
        // Car car3 = car1;

        car1.compareCars(car2);
    }
}
