import React from "react";
import { Button, Typography } from "@mui/material";
import { Grid } from "gridjs-react";

const Footer = () => {
  return (
    <div>
    
      <footer className="grid-container  bg-black text-white text-centermt-10">
        <div
          className="grid-item "
          item
          xs={12}
          sm={2}
          md={3}
          style={{ display: "flex", justifyContent: "space-between" }}
        >
          <div
            className="pb-5"
            variant="h6"
            style={{ display: "inline-block", margin: "5%" }}
          >
            <h1>Company</h1>
            <br />

            <ol className="text-center">
              <li>
                <button>ABOUT</button>
              </li>
              <li>
                <button>BLOG</button>
              </li>
              <li>
                <button>PRESS</button>
              </li>
              <li>
                <button>JOBS</button>
              </li>
              <li>
                <button>PARTNERS</button>
              </li>
            </ol>
          </div>

          <div
            className="pb-5"
            variant="h6"
            style={{ display: "inline-block", margin: "5%" }}
          >
            <h1>Solutions</h1>
            <br />

            <ol className="text-center">
              <li>
                <button>Marketing</button>
              </li>
              <li>
                <button>Analyics</button>
              </li>
              <li>
                <button>Commerce</button>
              </li>
              <li>
                <button>Insights</button>
              </li>
              <li>
                <button>Sopport</button>
              </li>
            </ol>
          </div>

          <div
            className="pb-5"
            variant="h6"
            style={{ display: "inline-block", margin: "5%" }}
          >
            <h1>Documentation</h1>
            <br />

            <ol className="text-center">
              <li>
                <button>Guides</button>
              </li>
              <li>
                <button>API Status</button>
              </li>
            </ol>
          </div>

          <div
            className="pb-5"
            variant="h6"
            style={{ display: "inline-block", margin: "5%" }}
          >
            <h1>Legal</h1>
            <br />

            <ol className="text-center">
              <li>
                <button>Claims</button>
              </li>
              <li>
                <button>Privacy</button>
              </li>
              <li>
                <button>Trems</button>
              </li>
            </ol>
          </div>
        </div>
        <div className="pt-20"item xs={12}>
            <Typography variant="body2"component='p' align="center">© 2024 All right are reserved. 

            </Typography>

        </div>
      </footer>
    </div>
  );
};

export default Footer;
