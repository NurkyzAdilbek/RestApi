package peaksoft.restapi.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.restapi.dto.SimpleResponse;
import peaksoft.restapi.dto.groupDto.GroupRequest;
import peaksoft.restapi.dto.groupDto.GroupResponse;
import peaksoft.restapi.dto.groupDto.SearchResponse;
import peaksoft.restapi.dto.groupDto.UpdateRequest;
import peaksoft.restapi.service.GroupService;

import java.util.List;


@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @PostMapping()
    public SimpleResponse saveGroup(@RequestBody GroupRequest groupRequest) {
        return groupService.saveGroup(groupRequest);
    }


    @PostMapping
  public   List<GroupResponse> getAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/id")
    public GroupResponse getGroupById(Long id) {
        return groupService.getGroupById(id);
    }

    @PutMapping("/{id}")
    public SimpleResponse updateGroup(@PathVariable Long id,
                                      @RequestBody UpdateRequest updateRequest) {
        return groupService.updateGroup(id,updateRequest);
    }

    @DeleteMapping("/{id}")
    public SimpleResponse deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroup(id);
    }

  @PostMapping("/{studentId}/{groupId}")
    public SimpleResponse assignStudentToGroup(
            @PathVariable Long studentId, @PathVariable Long groupId ) {
        return groupService.assignStudentToGroup(studentId,groupId);

    }

    @GetMapping("/search")
    public List<SearchResponse>searchGroup(@RequestParam String word){
        return groupService.searchGroup(word);
    }
}
