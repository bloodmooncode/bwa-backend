package blazor.Entity;

import jakarta.persistence.*;

import java.util.List;

/**
 * Created by ZYP on 2024/2/2 2:22PM
 */

@Entity
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private Integer userId ;
    private String name;
    private String timeHorizon;
    private String type;
    private Double maximumBuyingPower;
    private Double minimumBuyingPower;
    private Double maximumSellingPower;
    private Double minimumSellingPower;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SellingPower> sellingPowers;

    public Element() {
    }

    public Element(String name, String type, Double maximumBuyingPower, Double minimumBuyingPower, Double maximumSellingPower, Double minimumSellingPower) {
        this.name = name;
        this.type = type;
        this.maximumBuyingPower = maximumBuyingPower;
        this.minimumBuyingPower = minimumBuyingPower;
        this.maximumSellingPower = maximumSellingPower;
        this.minimumSellingPower = minimumSellingPower;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeHorizon() {
        return timeHorizon;
    }

    public void setTimeHorizon(String timeHorizon) {
        this.timeHorizon = timeHorizon;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaximumBuyingPower() {
        return maximumBuyingPower;
    }

    public void setMaximumBuyingPower(Double maximumBuyingPower) {
        this.maximumBuyingPower = maximumBuyingPower;
    }

    public Double getMinimumBuyingPower() {
        return minimumBuyingPower;
    }

    public void setMinimumBuyingPower(Double minimumBuyingPower) {
        this.minimumBuyingPower = minimumBuyingPower;
    }

    public Double getMaximumSellingPower() {
        return maximumSellingPower;
    }

    public void setMaximumSellingPower(Double maximumSellingPower) {
        this.maximumSellingPower = maximumSellingPower;
    }

    public Double getMinimumSellingPower() {
        return minimumSellingPower;
    }

    public void setMinimumSellingPower(Double minimumSellingPower) {
        this.minimumSellingPower = minimumSellingPower;
    }

    public List<SellingPower> getSellingPowers() {
        return sellingPowers;
    }

    public void setSellingPowers(List<SellingPower> sellingPowers) {
        this.sellingPowers = sellingPowers;
    }

}
