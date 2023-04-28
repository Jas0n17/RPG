default: Driver.java Battle.java Health.java Inventory.java Place.java Pokemon.java World.java
	javac Driver.java Battle.java Health.java Inventory.java Place.java Pokemon.java World.java

run: Driver.class Battle.class Health.class Inventory.class Place.class Pokemon.class World.class
	java Driver

clean:
	rm -f *.class