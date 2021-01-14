import React from 'react';
import { Route, Redirect, Switch } from 'react-router-dom';
import HomePage from './components/HomePage';
import CentralRegistryHome from './components/central-registry/CentralRegistryHome';
import CounterHome from './components/counter/CounterHome';
import HealthHome from './components/health/HealthHome';
import PoliceHome from './components/police/PoliceHome';
import VehicleHome from './components/vehicle/VehicleHome';


const AppRouter = () => {

    function hasRightRole(accessRole) {

        if (!accessRole) {
            return true;
        }

        let role = localStorage.getItem("role");
        if (role === accessRole) {
            return true;
        } else {
            return false;
        }

    }


    return (
        <Switch>
            <Route exact path="/" component={HomePage} />

            {/* rute za centralni registar nadovezuju se na /cent-reg */}
            <Route exact path="/cent-reg" component={CentralRegistryHome} />

            {/* rute za salter nadovezuju se na /counter */}
            <Route exact path="/counter" component={CounterHome} />

            {/* rute za vozila nadovezuju se na /vehicle */}
            <Route exact path="/vehicle" component={VehicleHome} />

            {/* rute za policiju nadovezuju se na /police */}
            <Route exact path="/police" component={PoliceHome} />

            {/* rute za zdravstvo nadovezuju se na /health */}
            <Route exact path="/health" component={HealthHome} />

            <Route exact path="/page-not-found" component={() => <h1>Page not found!</h1>} />
            <Redirect from="*" to="/page-not-found" />
        </Switch>
    );
}

export default AppRouter;