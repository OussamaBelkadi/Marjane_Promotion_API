package ma.yc.marjane.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResponseDto<T> {
    private String message ;
    private String code ;
    private String status ;
    private T data ;


}
