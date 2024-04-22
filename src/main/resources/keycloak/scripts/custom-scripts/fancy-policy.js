var context = $evaluation.getContext().getIdentity().getAttributes();
var identity = context.getIdentity();
var attributes = identity.getAttributes();

if (attributes.containsValue(' FANCY_RES_ACCESS_ATTRIBUTE', 'PRETTY_FANCY')) {
    $evaluation.grant();
} else {
    $evaluation.deny();
}



// Когда все готово нам нужно собрать JAR файл, для этого вызываем следующую команду:
//
// jar --create --file "/home/wizari/Programming/Angular/probation-test-backend/src/main/resources/keycloak/scripts/custom-scripts.jar" --no-manifest -C "/home/wizari/Programming/Angular/probation-test-backend/src/main/resources/keycloak/scripts/custom-scripts" .
//  пример -    jar --create --file "/path/to/your/custom-scripts.jar" --no-manifest -C "/path/to/your/custom-scripts" .

