
/**
/**
 * 정규식 클래스
 * @author 노종현 <beatz4@naver.com>
 */

class RegexUtil {
    
    /**
     * check email validation.
     * @param {email} 이메일 주소
     * @returns {result} 유효성 검사 결과
     */
    static email(email) {

        const pattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-za-z0-9\-]+/;
        return pattern.test(email) !== false;
    }

    /**
     * check phone number validation.
     * @param {phone} 전화번호
     * @returns {result} 유효성 검사 결과
     */
    static phone(phone) {
        
        const pattern = /^[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}/;
        return pattern.test(phone) !== false;
    }
}