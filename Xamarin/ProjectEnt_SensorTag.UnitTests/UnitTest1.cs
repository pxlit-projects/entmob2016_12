using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using GalaSoft.MvvmLight.Views;
using ProjectEnt_SensorTag.ViewModel;
using ProjectEnt_SensorTag.Model;
using GalaSoft.MvvmLight.Messaging;
using ProjectEnt_SensorTag.SensorTagLib;
using Robotics.Mobile.Core.Bluetooth.LE;

namespace ProjectEnt_SensorTag.UnitTests
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestLogin()
        {
            Messenger.Reset();
            var nav = new TestNotificationService();

            LoginViewModel vm = new LoginViewModel(nav);

            var user = new User();

            user.Username = "Example";

            vm.User = user;
            vm.Login.Execute(null);

            Assert.AreEqual(nav.WentBack,true);
        }

        [TestMethod]
        public void TestRegister()
        {
            Messenger.Reset();
            var nav = new TestNotificationService();

            RegisterViewModel vm = new RegisterViewModel(nav);

            var user = new User();

            user.Username = "Example";

            vm.User = user;
            vm.Register.Execute(null);

            Assert.AreEqual(nav.WentBack, true);
        }

        [TestMethod]
        public void TestLoginButton()
        {
            Messenger.Reset();
            var nav = new TestNotificationService();

            MainViewModel vm = new MainViewModel(nav);
            vm.Login.Execute(null);

            Assert.AreEqual(nav.CurrentPageKey, "Login");
        }
        [TestMethod]
        public void TestUserReceived()
        {
            Messenger.Reset();

            var vm = new RegenViewModel(null);
            var user = new User();
            Messenger.Default.Send<User>(user);

            Assert.AreNotEqual(vm.User, null);
        }

        [TestMethod]
        public void TestDevicePropertyChanged()
        {
            Messenger.Reset();

            var vm = new SensorTagDetailViewModel(null);
            bool propertyChanged = false;
            vm.PropertyChanged += (sender, e) =>
            {
                propertyChanged = true;
            };
            Assert.IsFalse(propertyChanged);

            vm.Device = null;

            Assert.IsTrue(propertyChanged);
        }

        [TestMethod]
        public void TestPropertyChanged()
        {
            Messenger.Reset();

            var vm = new SensorTagViewModel(null);
            bool propertyChanged = false;
            vm.PropertyChanged += (sender, e) =>
            {
                propertyChanged = true;
            };
            Assert.IsFalse(propertyChanged);

            vm.DeviceList = null;

            Assert.IsTrue(propertyChanged);
        }
    }

    public class TestNotificationService : INavigationService
    {

        private string currentPageKey;

        public string CurrentPageKey
        {
            get { return currentPageKey; }
            set { currentPageKey = value; }
        }

        private bool wentBack = false;

        public bool WentBack
        {
            get { return wentBack; }
            set { wentBack = value; }
        }


        public void GoBack()
        {
            wentBack = true;
        }

        public void NavigateTo(string pageKey)
        {
            this.currentPageKey = pageKey;
        }

        public void NavigateTo(string pageKey, object parameter)
        {
            throw new NotImplementedException();
        }
    }
}
