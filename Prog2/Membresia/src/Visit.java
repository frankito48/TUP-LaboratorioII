import java.util.Date;
class Visit {
    protected Customer customer;
    protected Date date;
    protected double serviceExpense;
    protected double productExpense;

    public Visit(String name, Date date) {
        customer = new Customer(name);
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double ex) {
        serviceExpense = ex;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double ex) {
        productExpense = ex;
    }

    public double getTotalExpense() {
        double total = serviceExpense + productExpense;
        if (customer.isMember()) {
            total -= total * DiscountRate.getServiceDiscountRate(customer.getMemberType());
            total -= total * DiscountRate.getProductDiscountRate(customer.getMemberType());
        }
        return total;
    }

    public String toString() {
        return "Visit: " + customer.getName() + ", Member Type: " + customer.getMemberType() +  ", Date: " + date + ", Service Expense: " + serviceExpense + ", Product Expense: " + productExpense + ", Total Expense: " + getTotalExpense();
    }
}