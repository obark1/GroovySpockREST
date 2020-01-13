package com.example.demo8min

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification


class CustomerControllerSpec extends Specification {

    //initial setup and variables

    CustomerController controller
    MockMvc mockMvc
    CustomerRepository repository
    ObjectMapper mapper = new ObjectMapper()
    def requestUri = '/api/customer'

    // our data
    Customer jon
    Customer tyrion
    String jonJsonString
    String tyrionJsonString

    void setup() {
        repository = Mock(CustomerRepository)
        controller = new CustomerController([repository: repository])
        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .alwaysDo(MockMvcResultHandlers.print())
                .build()

        jon = new Customer([givenName: 'Jon', surname: 'Snow'])
        tyrion = new Customer([givenName: 'Tyrion', surname: 'Lannister'])
        jonJsonString = mapper.writeValueAsString(jon)
        tyrionJsonString = mapper.writeValueAsString(tyrion)
}
    void 'get customers return a list of customers'() {
        given:
        repository.findAll() >> [jon, tyrion]

        and:
        def response = [jonJsonString, tyrionJsonString].toString()

        expect:
        mockMvc.perform(MockMvcRequestBuilders
               .get(requestUri))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.content().json(response))
    }








}

//    void 'name of test'() {
//        given:
//
//
//        when:
//
//
//        then:
//
//    }
//}
//
//void 'name of test 2'() {
//    given:
//    def a = 1
//
//    expect:
//    a == 1;
//}
//
//void 'just expect block'() {
//    expect:
//    Calculator.add(1,2) == 3
//}
//
//    @Unroll
//    void 'demonstrating unroll'() {
//        expect:
//        var1 +  var2 = result
//
//        where:
//        var1 | var2 | result
//
//        1 | 2 | 3
//        2 | 3 | 5
//        3 | 4 | 7
//        4 | 5 | 9
//    }
//
//    // fixture methods or lifecycle methods
//    def setup() {}  // run before every feature method
//    def cleanup() {} // run after every feature method
//
//    def setupSpec() {} // run before the first feature method
//    def cleanupSpec() {} // run before the last feature method
//
//
//
//
//
//
//    }