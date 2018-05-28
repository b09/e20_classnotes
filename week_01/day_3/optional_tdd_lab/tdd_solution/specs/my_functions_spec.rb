require( 'minitest/autorun' )
require( 'minitest/rg' )
require_relative( '../my_functions' )

class My_Functions < MiniTest::Test

  # Write a function that takes has two parameters, array1 and array2
  # It should return the sum of the array lengths
  def test_add_length_of_arrays
    # arrange
    array1 = [ "Zsolt", "Sandy" ]
    array2 = [ "John", "Darren", "Kat" ]
    # act
    result = add_array_lengths( array1, array2 )
    # assert
    assert_equal( 5, result )
  end

  # Write a function that has a parameter named numbers
  # It should return the sum value of an array passed as the argument
  def test_sum_array
    # arrange

    # act
    result = sum_array( [ 1,2,3,4,5 ] )
    # assert
    assert_equal( 15, result )
  end

  # Write a function that has two parameters, array and item
  # It should return true if the item exists in the array otherwise it should return false
  def test_find_item_true
    # arrange
    houses = [ 'Hufflepuff', 'Slytherin', 'Gryffindor', 'Ravenclaw' ]
    # act
    result = find_item( houses, "Ravenclaw" )
    # assert
    assert_equal( true, result )
  end

  def test_find_item_false
    # arrange
    houses = [ 'Hufflepuff', 'Slytherin', 'Gryffindor', 'Ravenclaw' ]
    # act
    result = find_item( houses, "Batman" )
    # assert
    assert_equal( false, result )
  end

  # Write a function that has one parameter hash
  # It should return the first key from the hash
  def test_get_first_key
    # arrange
    wallets = {
      'Kat' => 12,
      'John'  => 10,
      'Darren'  => 1356,
      'Zsolt' => 1
    }
    # act 
    result = get_first_key( wallets )
    # assert
    assert_equal( 'Kat', result )
  end

end
