public enum ProductType {
    PHONE("Cep Telefonu"),
    NOTEBOOK("Notebook");

    private String typeName;

    ProductType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName(){
        return this.typeName;
    }
}
