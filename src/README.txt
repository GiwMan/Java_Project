A.M : 1115201700076
ΜΑΝΤΖΟΥΡΑΝΗΣ ΓΙΩΡΓΟΣ

********************************************************************************
* Compilation : javac main/Main.java                                             *
* Execution : java main.Main [αριθμός_χωριτηκότητας] [αριθμός_χώρων_επιβατών]    *
* Διαγραφή .class :                                                              *
*   rm -f main/*.class                                                             *
*   rm -f planes/*.class                                                           *
*   rm -f employees/*.class                                                        *
*   rm -f counter/*.class                                                          *
********************************************************************************


Στην εργασία αυτή έχω δημιουργήσει 3 διαφορετικά packages.
Στο πρώτο πακέτο counter, υλοποιώ μια public Class Counter, 
η οποία αποτελείται από ένα private member int και διάφορες 
συναρτήσεις set/get για την διαχείριση της τιμής αυτής έξω
από την συνάρτηση. Τα αντικείμενα της κλάσσης αυτής στην ουσία
αυξάνουν τον αριθμό αντικειμένων που δημιουργούνται κάθε φορά .

Το δεύτερο πακέτο είναι αυτό των employees. Στο πακέτο αυτό,
έχει υλοποιηθεί η abstract public class Employee, η οποία 
περιέχει protected members έναν int και ένα String. Είναι protected
επειδή στο ίδιο πακέτο έχω δημιουργήσει και τις ζητούμενες κλάσσεις που
αναπαριστούν τους SecurirtyEmployee, MaintenanceEmployee, CleaningEmployee.
οι οποίες είναι και subclasses της Employee. Για κάθε μία από τις παραπάνω κλάσσεις,
υπάρχουν και οι ανάλογες συναρτήσεις δημιουργίας. Όσον αφορά τον κώδικα των παραπάνω
κλάσσεων έχω κάνει @Override τις clone(),equals() και toString() της Object, ώστε να
έχω τα επιθυμητά αποτελέσματα. Στην equals() αρχικά συγκρίνω τα id του κάθε Employee
και αν είναι ίσα προχοράω και στο όνομα. Έχει υλοποιηθεί επίσης η identical(), η οποία
το μόνο που κάνει είναι να ελέγχει τον δείκτη this με το αντικέιμενο κάθε φορά που δίνεται
ως παράμετρος.

Το τρίτο και τελευταίο package είναι το planes, το οποίο περιλαμβάνει τις public classes
των CargoBay, EquipmentCompartment, PassengerCompartment, Plane, PlaneComponent,PrivateComponent.
Από τα παραπάνω οι κλάσεις PlaneComponent και PrivateComponent είναι abstract. Κάθε μια από
τις παραπάνω κλάσεις κάνει @Override της clone(),equals() και toString() ενώ έχει υλοποιημένη
την identical() με παρόμοιο τρόπο με αυτόν του πακέτου employees. Δεν υπάρχει κάποια ιδιατερότητα
όσον αφορά την τεχνική υλοποίησης των παραπάνω που να διαφέρει σημαντικά από αυτήν της άσκησης 3.
Παρόλα αυτά να σηειωθεί ότι στην κλάσση αεροπλάνο κρατάω σε μια private int το id του αεροπλάνου
ενώ υπάρχει και ένα protected πεδίο ακεραίου στην κλάσση PlaneComponent, από την οποία και κληρονομούν
έμμεσα ή άμμεσα οι υπόλοιπες κλάσεις του πακέτου εκτός της Plane, που κληρονομεί από την Object.

Η main βρίσκεται στο αρχείο Main.java.

