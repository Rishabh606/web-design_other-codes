package Lecture20.story_generics;

public class Car implements Comparable<Car>{
	int Speed;
	int Price;

	Car(int Speed, int Price){
		this.Speed = Speed;
		this.Price = Price;
	}

	@Override
	public int compareTo(Car o) {
		return this.Price - o.Price;
	}
	
	@Override
	public String toString() {
       return "[Speed = " + this.Speed + ", Price = " + this.Price + "]"; 
	}
}
