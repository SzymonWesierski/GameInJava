public class BasicFigures {

    private Figure[] tab;
    public BasicFigures(){
        Figure[] tablica = new Figure[3];
        tablica[0] = new Rectangle(10,12);
        tablica[1] = new Circle(1);
        //tablica[2] = new Triangle(2,3,4);
    }

    Figure[] getFlatFigures(){
        return this.tab;
    }
}
