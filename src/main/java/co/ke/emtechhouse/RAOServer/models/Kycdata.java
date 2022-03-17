package co.ke.emtechhouse.RAOServer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Kycdata {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    private String salutation;
//    @Column(nullable = false)
    private String cust_first_name;
	private String cust_middle_name;
//    @Column(nullable = false)
    private String cust_last_name;

	private String short_name;
	private String nick_name;

//    @Column(nullable = false)
	private Date cust_dob;
//    @Column(nullable = false)
	private String placeofbirth;
//    @Column(nullable = false)
	private String countryofbirth;

//    @Column(nullable = false)
	private String gender;

//    @Column(nullable = false)
	private String state;
//    @Column(nullable = false)
	private String country = "kenya";
//    @Column(nullable = false)
	private String city = "Nairobi";
//    @Column(nullable = false)
	private String zip;
//    @Column(nullable = false)
	private String physical_state;
//    @Column(unique = true, nullable = false, length = 15)
	private String phone;
	private String phone_home;
	private String phone_home2;
//    @Column(unique = true, nullable = false, length = 15)
    private String phone_cell;
//    @Column(unique = true, nullable = false, length = 15)
    private String preferredphone;
	private String preferredphonetype;
	private String address_line1;
	private String address_line2;

//    @Column(unique = true, nullable = false)
    private String email;
	private String email_home;
//    @Column(unique = true, nullable = false)
    private String preferredemail;
//    @Column(unique = true, nullable = false, length = 30)
	private String passportno;
//    @Column(unique = true, nullable = false, length = 30)
    private String uniqueidnumber;
//    @Column(unique = true, nullable = false, length = 30)
	private String nat_id_card_num;

	private String education;
	private String occupation;
	private String cust_language;
	private BigDecimal annualrevenue;
	private String spouseid;
	private String mother_name;
	private String father_name;
}
