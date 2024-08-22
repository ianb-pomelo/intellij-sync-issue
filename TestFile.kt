import com.google.auto.factory.AutoFactory

@AutoFactory
class TestFile(val test: String) {
}

class Other(val factory: TestFileFactory) {

}