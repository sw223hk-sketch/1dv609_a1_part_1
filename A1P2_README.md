# Answer to study questions

1. What is a unit?
   A unit refers to the smallest testable component of code, often a function, method, or class, designed for isolated testing to ensure correctness before integration.

2. How does TDD differ from standard types of testing?
   TDD flips things around. Instead of writing code first and test code with unit testing, we write the unit test first and then write just enough to make that test pass. TDD lets unit test drive development of code.

3. What is an Oracle?
   A test oracle is a provider of currect outputs. In testing, the result from the system under test (SUT) are compared to the outputs provided by the oracle to determine if the system behaves correctly.

4. How does an oracle know what is right?
   An oracle decides correctness by referencing something known to be correct, like specs, previous outputs, or rules of the system.

5. What might you need to change in the SUT in order to make good use of unit testing? compared to when not doing unit asserts?
   To make the SUT suitable for unit testing, we usually need to restructure the code. This includes breaking large functions into smaller units, returning values instead of only updating UI, removing tight coupling to DOM or global state, injecting dependencies, and organizing logic so that it becomes ddeterministic and testable. Without these changes, the code may rely too much on side effects, making unit asserts impossible or unreliable.

6. Do all test need to use assert?
   Not necessarily, but every meaningful test must include at least one assertion to verify the expected outcome. Without an assertion, the test cannot confirm whether the behavior is correct.

7. What makes black box testing different from white box testing?
   Black box testing focuses on functionality without knowledge of the internal code, while white box testing analyzes the internal code structure, logic, and pathways.

8. Why might we want to use black box testing?
   Black box testing is useful because it lets you evaluate what the software does rather than how it is implemented. This helps you stay focused on expected behavior, catch user-level issues, and avoid being biased by internal code structure.

9. What is the purpose of unit-testing?
   It is to verify individual, isolated pieces of code work correctly as inttended, cathing bugs early, improving code quality, simplifying maintenance, and enabling confident refactoring by ensuring changes don't break existing functionality.

10. What are equivalence partitioning and boundary value analysis?
    Equivalence Partitioning groups similar inputs into classes to test fewer representatice values, assuning all in a class behave alike,
    while Boundary Value Analysis focuses on testing vlaues at hte edges(minium, maximum, just inside/outside) of thess partitions.

11. Why do we use TDD? What is its purpose?
    Test-driven development is a software development method in which tests are written before the code. It validates taht the code meets defined requirements, keeps the codebase correct and modular, and supports safe, incremental changes throughout development.

12. If multiple tests are broken, which tests are most important to priorities fixing?
    The most important tests to fix first are those that affect other tests or are critical for core funcionality. By addressing these, we prevent cascading failures and ensure that dependent parts of the system can be tested reliably.

13. Can we always have 100% code-coverage?
    No, we cannot always achieve 100% code coverage. Reaching the final few percent often requires disproportionate effort and may waste resources without significanlty improving software quality. The ogal is to cover the critical and meaningful parts of the code, not necessarily every single line.

14. What are the different types of coverage criteria?
    Coverage criteria in software testing measure how thoroughly code or requirements are tested.
    Key types including: Statement/Line Coverage (executing each line of code)
    Branch/Decision Coverage (testing true/false paths of conditions)
    Function Coverage (calling fucntions)
    Condition Coverage (testing boolean sub-experessions)
    advanced forms like MC/DC(Modified Condition/Decision Coverage) for cirtical systems, high-level Requirements/Product Coverage for features.

15. Why do we use mock objects?
    We use mock objects to simulate parts of a system(like databases, APIs, or other dependencies) so that tests can run quickly and reliably without needing real data or external resouces. This allows us to focus on testing the acutal logic and intractions of the code under test.

16. What is the difference between a mock, a stub, and a spy?
    Stub is a simple fake implementation of a function aht returns predefined data to the SUT. (provide data)
    Mock is a more sophisticated fake onject tjat simulateds behavior and verify interactions. (simulate and assert behavior)
    Sopy is a wrapper around a real function or object that records how it is used. (observe and record data)

17. Does 100% coverage mean we are bug-free?
    No, it doesn't. It only means that every line of code was executed by tests, not thay every possible scenario, input, or logical path was validated, often leading to a false sense of securiy, as poor test qulity or missed edge cases can still hide critical defects.

18. Does 100% MCDC coverage mean we are bug-free?
    No. 100% MCDC ensures all logical conditions are tested, but it doesn't guarantee the program is bug-free because it can't catch missing requiremnts, runtime errors, or integration issues.

19. Can we prove that we're 100% bug-free?
    No. It is impossible to test all possible senarios and inputs, so we cannot guarantee a program is completely free of bugs.

20. In TDD, why do we go for RED first?
    We start with RED to define the goal clearly: the test shows what functionality we want to implement, and failing it confirms that the feature is not yet present. This guides development and ensures we only wirte code necessary to pass the test.

# jacococ report

- run command to get reprot: ./gradlew clean test jacocoTestReport
- generated report locate in /Users/sisiwu/Downloads/1DV609_Testing/Assignment/A1/1dv609_a1_part_1/build/reports/jacoco/test/html

| Coverage Type | What it checks                           | How. tosatisfy                                                     |
| ------------- | ---------------------------------------- | ------------------------------------------------------------------ |
| Instructions  | Every bytecode executed at least once    | Call the method, execute every line                                |
| Branches      | Every outcome of every decision executed | Test true/false paths for `if`, `switch`, ternary, loop conditions |
