import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Visit visit = new Visit("John", new Date());
        visit.setServiceExpense(100);
        visit.setProductExpense(50);
        visit.customer.setMember(true);
        visit.customer.setMemberType("Premium");
        System.out.println(visit);
    }
}