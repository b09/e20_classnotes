require('minitest/autorun')
require_relative('../classes.rb')

class TestBankAccount < MiniTest::Test

  def test_account_getters
    account = BankAccount.new("John", 500, "business")
    assert_equal("John", account.holder_name)
    assert_equal(500, account.amount)
    assert_equal("business", account.type)

  end

  def test_account_setters
    account = BankAccount.new("John", 500, "business")
    account.holder_name = "Jenny"
    account.amount = 1000
    account.type = "personal"

    assert_equal("Jenny", account.holder_name)
    assert_equal(1000, account.amount)
    assert_equal("personal", account.type)
  end

  def test_deposit_money
    account = BankAccount.new("John", 500, "business")
    account.deposit(10)
    assert_equal(510, account.amount)
  end

  def test_withdraw_money
    account = BankAccount.new("John", 500, "business")
    account.withdraw(20)
    assert_equal(480, account.amount)
  end

  def test_print_statement__withdrawal
    account = BankAccount.new("John", 500, "business")
    account.withdraw(20)
    log = [{
      name: "John",
      amount: -20
    }]
    result = account.print_statement()
    assert_equal(log, result)
  end

  def test_print_statement__withdrawal_many
    account = BankAccount.new("John", 500, "business")
    account.withdraw(20)
    account.withdraw(30)
    account.withdraw(10)
    account.withdraw(100)
    log = [{
      name: "John",
      amount: -20
    },
    {
      name: "John",
      amount: -30
    },
    {
      name: "John",
      amount: -10
    },
    {
      name: "John",
      amount: -100
    }]
    result = account.print_statement()
    assert_equal(log, result)
  end


  def test_print_statement__deposit
    account = BankAccount.new("John", 500, "business")
    account.deposit(20)
    log = [{
      name: "John",
      amount: 20
    }]
    result = account.print_statement()
    assert_equal(log, result)
  end

  def test_print_statement__deposit_many
    account = BankAccount.new("John", 500, "business")
    account.deposit(20)
    account.deposit(30)
    account.deposit(10)
    account.deposit(100)
    log = [{
      name: "John",
      amount: 20
    },
    {
      name: "John",
      amount: 30
    },
    {
      name: "John",
      amount: 10
    },
    {
      name: "John",
      amount: 100
    }]
    result = account.print_statement()
    assert_equal(log, result)
  end























end
