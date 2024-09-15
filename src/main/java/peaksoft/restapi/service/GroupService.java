package peaksoft.restapi.service;

import peaksoft.restapi.dto.groupDto.GroupRequest;
import peaksoft.restapi.dto.SimpleResponse;
import peaksoft.restapi.dto.groupDto.GroupResponse;
import peaksoft.restapi.dto.groupDto.SearchResponse;
import peaksoft.restapi.dto.groupDto.UpdateRequest;

import java.util.List;

public interface GroupService {
    SimpleResponse saveGroup(GroupRequest groupRequest);
    List<GroupResponse> getAllGroups();
    GroupResponse getGroupById(Long id);
    SimpleResponse updateGroup(Long id, UpdateRequest updateRequest);
    SimpleResponse deleteGroup(Long id);
    SimpleResponse assignStudentToGroup(Long studentIdId, Long groupId);
    List<SearchResponse>searchGroup(String word);

}
