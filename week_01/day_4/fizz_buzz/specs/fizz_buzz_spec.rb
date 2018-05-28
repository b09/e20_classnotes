require('minitest/autorun')
require_relative('../fizz_buzz')

class FizzBuzzTest < Minitest::Test

  def test_fizz_buzz_3_returns_fizz
    assert_equal("Fizz", fizz_buzz(3))
  end

  def test_fizz_buzz_18_returns_fizz
    assert_equal("Fizz", fizz_buzz(18))
  end

  def test_fizz_buzz_7_returns_7_as_string
    assert_equal("7", fizz_buzz(7))
  end

  def test_fizz_buzz_127_returns_127_as_string
    assert_equal("127", fizz_buzz(127))
  end

  def test_fizz_buzz_5_returns_buzz
    assert_equal("Buzz", fizz_buzz(5))
  end

  def test_fizz_buzz_155_returns_buzz
    assert_equal("Buzz", fizz_buzz(155))
  end

  def test_fizz_buzz_15_returns_fizzbuzz
    assert_equal("FizzBuzz", fizz_buzz(15))
  end

  def test_fizz_buzz_300_returns_fizzbuzz
    assert_equal("FizzBuzz", fizz_buzz(300))
  end
end
