package peaksoft.restapi.dto.groupDto;

import lombok.Builder;
import lombok.Data;


@Builder
public record UpdateRequest (
    String groupName,
    String description

){

}
