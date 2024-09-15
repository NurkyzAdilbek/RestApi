package peaksoft.restapi.service.serviceImpl;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import peaksoft.restapi.dto.SimpleResponse;
import peaksoft.restapi.dto.groupDto.GroupRequest;
import peaksoft.restapi.dto.groupDto.GroupResponse;
import peaksoft.restapi.dto.groupDto.SearchResponse;
import peaksoft.restapi.dto.groupDto.UpdateRequest;
import peaksoft.restapi.entity.Group;
import peaksoft.restapi.entity.Student;
import peaksoft.restapi.repository.GroupRepository;
import peaksoft.restapi.repository.StudentRepository;
import peaksoft.restapi.service.GroupService;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    private final  GroupRepository groupRepository;
    private final StudentRepository studentRepository;
    @Override
    public SimpleResponse saveGroup(GroupRequest groupRequest) {
Group group = new Group();
group.setGroupName(groupRequest.groupName());
group.setImageLink(groupRequest.imageLink());
group.setDescription(groupRequest.description());
groupRepository.save(group);
        return SimpleResponse
                .builder()
                .message("Success")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public List<GroupResponse> getAllGroups() {
        return groupRepository.getAllGroups();
    }

    @Override
    public GroupResponse getGroupById(Long id) {
        return groupRepository.getGroupById(id);
    }

    @Override
    public SimpleResponse updateGroup(Long id, UpdateRequest updateRequest) {
        Group group = groupRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Not found"));
        group.setGroupName(updateRequest.groupName());
        group.setDescription(updateRequest.description());
        groupRepository.save(group);
        return SimpleResponse
                .builder()
                .message("Success")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public SimpleResponse deleteGroup(Long id) {
    Group group=    groupRepository.findById(id).orElseThrow(()->
                new EntityExistsException("Not found"));
        groupRepository.deleteById(group.getId());
        return SimpleResponse
                .builder()
                .message("Success")
                .status(HttpStatus.OK)
                .build();
    }

    @Override
    public SimpleResponse assignStudentToGroup(Long studentIdId, Long groupId) {
        Group group=    groupRepository.findById(groupId).orElseThrow(()->
                new EntityExistsException("Not found"));
      Student student=  studentRepository.findById(studentIdId).orElseThrow(()->new EntityExistsException("Student with id "+ studentIdId+" not found"));
        student.setGroup(group);
        return null;
    }

    @Override
    public List<SearchResponse> searchGroup(String word) {
        return groupRepository.searchGroupsByGroupName(word);
    }
}
