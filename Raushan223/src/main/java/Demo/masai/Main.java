package Demo.masai;

import java.util.Scanner;



import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

public class Main {
	
	
	
	public static void main(String[] args) {
	
         Scanner sc=new Scanner(System.in);
         int c;
         do {
        	 System.out.println("1. Add Author");
        	 System.out.println("2. Print Author");
        	 System.out.println("3. Update Rating");
        	 System.out.println("4. Delete Author by id");
        	 System.out.println("0. Exit");
        	 
        	 c=sc.nextInt();
        	 
        	 switch(c) {
        	 case 1:
        		 Addui(sc);
        		 break;
        	 case 2:
        		Printui(sc);
        		 break;
        	 case 3:
        		 Updateui(sc);
        		 break;
        	 case 4:
        		 deleteui(sc);
        		 break;
        	 case 0:
       System.out.println("thanks visit again");
        		 break;
        		 default :
        			 System.out.println("Invalid Salection");
        			 break;
        	 }
        	 
         }while(c!=0);
         sc.close();
         
	}
	static EntityManagerFactory emf;
	static {
		emf=Persistence.createEntityManagerFactory("Connect");
	}

	 static void Addui(Scanner sc) {
		
		
		EntityManager em=emf.createEntityManager();
		
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter Rating");
		double rating =sc.nextDouble();
		
		Author a=new Author(name,rating);
		
		EntityTransaction et=em.getTransaction();
		
		et.begin();
		try {
		em.persist(a);
		System.out.println("added successfully");
		}
		catch(PersistenceException e) {
			System.out.println(e.getMessage());
		}finally {
			et.commit();
			
			em.close();
		}
		
		
		
	}


	 static void Printui(Scanner sc) {
		// TODO Auto-generated method stub
		
	}


    static void Updateui(Scanner sc) {
    	
		EntityManager em=emf.createEntityManager();
		Author ab=null;
		System.out.println("Enter id");
		String id=sc.next();
		System.out.println("Enter Rating");
		double rating =sc.nextDouble();
		
		ab=em.find(Author.class, id);
		if (ab == null) {
			System.out.println(" not present in data bases");
			return;
		}
		ab.setRating(rating);
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(ab);
		et.commit();
		em.close();		
		
		
		}
		
		
			
			
			
			
		
	


	 static void deleteui(Scanner sc) {

			EntityManager em=emf.createEntityManager();
			Author ab=null;
			System.out.println("Enter id");
			String id=sc.next();
			
			
			ab=em.find(Author.class, id);
			if (ab == null) {
				System.out.println(" not present in data bases");
				return;
			}
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			try {
			em.remove(ab);
			System.out.println("Deleted successfully");
			}
			catch(IllegalAccessError e) {
				System.out.println(e.getMessage());
			}
			finally {
			et.commit();
			em.close();	
			}
		
	}

}
