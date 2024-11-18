package kr.or.ddit.vo;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.groups.Default;
import java.io.Serializable;
import java.util.Objects;

/**
 * Domain Layer(Java Bean 규약 적용)
 */
@Data
@EqualsAndHashCode(of = "id")
public class PersonVO implements Serializable {
    @NotBlank(groups = {Default.class, DeleteGroup.class})
    private transient String id;
    @NotBlank
    private String name;
    @NotBlank(groups = InsertGroup.class)
    private String gender;
    @NotBlank(groups = InsertGroup.class)
    private String age;
    @NotBlank
    private String address;
}
