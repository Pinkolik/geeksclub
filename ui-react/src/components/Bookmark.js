import React from "react";
import { NavLink } from "react-router-dom";

const Bookmark = props => (
    <div className="col-12">
        <div className="alert alert-primary" role="alert">
            <h5>
                <a href={props.bookmark.url} target={'_blank'}>
                    {props.bookmark.title}
                </a>
            </h5>
          <p className={"mb-0"}>
            { props.bookmark.tags.map(tag =>
              <span key={tag} style={{paddingRight: "10px"}}>
               <NavLink to={`/tags?tag=${tag}`}>
                 <span className="badge badge-primary" style={{fontSize: "15px"}}>{tag}</span>
               </NavLink>
              </span>
            )}
          </p>
        </div>
    </div>
);
export default Bookmark;
