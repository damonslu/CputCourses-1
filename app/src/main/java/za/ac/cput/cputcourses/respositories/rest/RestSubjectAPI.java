package za.ac.cput.cputcourses.respositories.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import za.ac.cput.cputcourses.model.Subject;
import za.ac.cput.cputcourses.respositories.RestAPI;

/**
 * Created by hashcode on 2015/09/01.
 */
public class RestSubjectAPI implements RestAPI<Subject,Long>  {
    final String BASE_URL="http://10.0.0.7:8080/api/";
    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Subject get(Long id) {
        final String url = BASE_URL+"subject/"+id.toString();
        HttpEntity<Subject> requestEntity = new HttpEntity<Subject>(requestHeaders);
        ResponseEntity<Subject> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Subject.class);
        Subject subject = responseEntity.getBody();
        return subject;
    }

    @Override
    public String post(Subject entity) {
        final String url = BASE_URL+"subject/create";
        HttpEntity<Subject> requestEntity = new HttpEntity<Subject>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Subject entity) {
        final String url = BASE_URL+"subject/update/"+entity.getId().toString();
        HttpEntity<Subject> requestEntity = new HttpEntity<Subject>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Subject entity) {
        final String url = BASE_URL+"subject/delete/"+entity.getId().toString();
        HttpEntity<Subject> requestEntity = new HttpEntity<Subject>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Subject> getAll() {
        List<Subject> subjects = new ArrayList<>();
        final String url = BASE_URL+"subjects/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Subject[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Subject[].class);
        Subject[] results = responseEntity.getBody();

        for (Subject subject : results) {
            subjects.add(subject);
        }
        return subjects;
    }
}
