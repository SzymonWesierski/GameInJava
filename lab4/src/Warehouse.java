public class Warehouse {
    private Product[] productlist = new Product[];

    public Product[] getProduct() {
        return productlist;
    }

    public Warehouse(int number){
        this.productlist = new Product[number];

        for(int i = 0; i < number; i++){
            this.productlist[i] = null;
        }

    }
}
