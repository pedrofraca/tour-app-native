import io.github.pedrofraca.domain.model.StageModel
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class TestStage {
    @Test
    fun testStageIsCompleted() {
        assertTrue("Stage must be completed if the name of the winner is not null",
                StageModel(name = "TestStage", winner = "Pedro", stage = "1").completed())
    }

    @Test
    fun testStageIsNotCompleted() {
        assertFalse("Stage mustn't be completed if the name of the winner is not null",
                StageModel(name = "TestStage", stage = "1").completed())
    }
}