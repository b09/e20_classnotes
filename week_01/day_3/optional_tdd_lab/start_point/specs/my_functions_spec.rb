require( 'minitest/autorun' )
require( 'minitest/rg' )
require_relative( '../my_functions' )

class My_Functions < MiniTest::Test

  # Write a function that takes has two parameters, array1 and array2
  # It should return the sum of the array lengths
  def test_add_length_of_arrays
    result = add_array_lengths( [ "Zsolt", "Sandy" ], [ "John", "Darren", "Kat" ] )
    assert_equal( 5, result )
  end

  # # Write a function that has a parameter named numbers
  # # It should return the sum value of an array passed as the argument
  # def test_sum_array
  #   result = sum_array( [ 1,2,3,4,5 ] )
  #   assert_equal( 15, result )
  # end

  # # Write a function that has two parameters, array and item
  # # It should return true if the item exists in the array otherwise it should return false
  # def test_find_item_true
  #   result = find_item( [ 'Hufflepuff', 'Slytherin', 'Gryffindor', 'Ravenclaw' ], "Ravenclaw" )
  #   assert_equal( true, result )
  # end

  # def test_find_item_false
  #   result = find_item( [ 'Hufflepuff', 'Slytherin', 'Gryffindor', 'Ravenclaw' ], "Batman" )
  #   assert_equal( false, result )
  # end

  # Write a function that has one parameter hash
  # It should return the first key from the hash
  # def test_get_first_key
  #   wallets = {
  #     'Kat' => 12,
  #     'John'  => 10,
  #     'Darren'  => 1356,
  #     'Zsolt' => 1
  #   }
  #   result = get_first_key( wallets )
  #   assert_equal( 'Kat', result )
  # end

end
