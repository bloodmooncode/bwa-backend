package blazor.Email;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

/**
 * Created by ZYP on 2024/4/19 12:46AM
 */
@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
//        TODO: Regex to validate email
        return true;
    }
}

