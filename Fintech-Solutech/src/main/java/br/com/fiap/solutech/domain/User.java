package br.com.fiap.solutech.domain;

import br.com.fiap.solutech.dto.user.UserRegisterDto;
import br.com.fiap.solutech.dto.user.UserUpdateDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String mail;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean notifications;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private InvestorInfo investorInfo;

    @ManyToMany(mappedBy = "users")
    private List<Investment> investment;


    public User(UserRegisterDto dto) {
        name = dto.name();
        mail = dto.mail();
        password = dto.password();
        notifications = dto.notifications();
        investorInfo = new InvestorInfo(dto);
        investorInfo.setUser(this);
    }


    public void updateData(UserUpdateDto dto) {
        if(dto.name() != null){
            name = dto.name();
        }
        if(dto.mail() != null){
            mail = dto.mail();
        }
        if(dto.password() != null){
            password = dto.password();
        }
        if(dto.notifications()){
            notifications = true;
        }if(dto.riskLevel() != null){
            investorInfo.setRiskLevel(dto.riskLevel());
        }
    }
}
