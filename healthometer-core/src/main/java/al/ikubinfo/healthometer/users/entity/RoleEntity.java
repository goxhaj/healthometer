package al.ikubinfo.healthometer.users.entity;

import al.ikubinfo.commons.entity.BaseEntity;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends BaseEntity {

  @Column(name = "name")
  protected String name;

  @Column(name = "description")
  private String description;
}
